package com.colman.studentsapp.ui.edit

import android.os.Bundle
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentsapp.R
import com.colman.studentsapp.model.Student
import com.colman.studentsapp.model.StudentRepository
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.appbar.MaterialToolbar
import com.colman.studentsapp.ui.applyStatusBarInsetPadding

class EditStudentActivity : AppCompatActivity() {

    private var studentUuid: String? = null
    private var student: Student? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_form)

        val toolbar: MaterialToolbar = findViewById(R.id.studentFormToolbar)
        toolbar.applyStatusBarInsetPadding()
        toolbar.title = getString(R.string.edit_student)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentUuid = intent.getStringExtra(EXTRA_STUDENT_UUID)
        student = studentUuid?.let { StudentRepository.findByUuid(it) }

        val image: ImageView = findViewById(R.id.studentFormImage)
        val idInput: EditText = findViewById(R.id.studentFormId)
        val nameInput: EditText = findViewById(R.id.studentFormName)
        val addressInput: EditText = findViewById(R.id.studentFormAddress)
        val checkedInput: CheckBox = findViewById(R.id.studentFormChecked)
        val saveButton: MaterialButton = findViewById(R.id.studentFormSave)
        val deleteButton: MaterialButton = findViewById(R.id.studentFormDelete)
        val cancelButton: MaterialButton = findViewById(R.id.studentFormCancel)

        val s = student ?: run {
            Snackbar.make(idInput, getString(R.string.student_not_found), Snackbar.LENGTH_LONG)
                .show()
            finish()
            return
        }

        image.setImageResource(s.imageResId)
        idInput.setText(s.id)
        nameInput.setText(s.name)
        addressInput.setText(s.address)
        checkedInput.isChecked = s.isChecked

        deleteButton.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.delete_student))
                .setMessage(getString(R.string.confirm_delete_message))
                .setNegativeButton(android.R.string.cancel, null)
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    val deleted = StudentRepository.deleteByUuid(s.uuid)
                    if (deleted) {
                        setResult(RESULT_OK)
                        finish()
                    } else {
                        Snackbar.make(
                            deleteButton,
                            getString(R.string.student_not_found),
                            Snackbar.LENGTH_SHORT
                        ).show()
                    }
                }
                .show()
        }

        saveButton.setOnClickListener {
            val newId = idInput.text.toString().trim()
            val newName = nameInput.text.toString().trim()
            val newAddress = addressInput.text.toString().trim()
            val newChecked = checkedInput.isChecked

            if (newId.isEmpty() || newName.isEmpty()) {
                Snackbar.make(
                    saveButton,
                    getString(R.string.error_empty_fields),
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Use repository's atomic update
            val result = StudentRepository.updateByUuid(
                uuid = s.uuid,
                newId = newId,
                newName = newName,
                newAddress = newAddress,
                newChecked = newChecked
            )

            when (result) {
                StudentRepository.UpdateResult.SUCCESS -> {
                    setResult(RESULT_OK)
                    finish()
                }

                StudentRepository.UpdateResult.DUPLICATE_ID -> {
                    Snackbar.make(
                        saveButton,
                        getString(R.string.error_duplicate_id),
                        Snackbar.LENGTH_LONG
                    ).show()
                }

                StudentRepository.UpdateResult.NOT_FOUND -> {
                    Snackbar.make(
                        saveButton,
                        getString(R.string.student_not_found),
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            }
        }

        cancelButton.setOnClickListener { finish() }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    companion object {
        const val EXTRA_STUDENT_UUID = "student_uuid"
    }
}
