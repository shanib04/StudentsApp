package com.colman.studentsapp.ui.create

import android.os.Bundle
import android.view.MenuItem
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentsapp.R
import com.colman.studentsapp.model.StudentRepository
import com.google.android.material.button.MaterialButton
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.colman.studentsapp.ui.applyStatusBarInsetPadding

class NewStudentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_form)

        val toolbar: MaterialToolbar = findViewById(R.id.studentFormToolbar)
        toolbar.applyStatusBarInsetPadding()
        toolbar.title = getString(R.string.add_student_title)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val image: ImageView = findViewById(R.id.studentFormImage)
        val idInput: EditText = findViewById(R.id.studentFormId)
        val nameInput: EditText = findViewById(R.id.studentFormName)
        val addressInput: EditText = findViewById(R.id.studentFormAddress)
        val checkedInput: CheckBox = findViewById(R.id.studentFormChecked)
        val saveButton: MaterialButton = findViewById(R.id.studentFormSave)
        val deleteButton: MaterialButton = findViewById(R.id.studentFormDelete)
        val cancelButton: MaterialButton = findViewById(R.id.studentFormCancel)

        image.setImageResource(R.drawable.ic_person_24)
        deleteButton.visibility = android.view.View.GONE

        saveButton.setOnClickListener {
            val id = idInput.text.toString().trim()
            val name = nameInput.text.toString().trim()
            val address = addressInput.text.toString().trim()
            val checked = checkedInput.isChecked

            if (id.isEmpty() || name.isEmpty()) {
                Snackbar.make(
                    saveButton,
                    getString(R.string.error_empty_fields),
                    Snackbar.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Use repository API that generates UUID and prevents duplicate IDs
            val created = StudentRepository.createStudent(
                id = id,
                name = name,
                address = address,
                isChecked = checked,
                imageResId = R.drawable.ic_person_24
            )

            if (created == null) {
                Snackbar.make(
                    saveButton,
                    getString(R.string.error_duplicate_id),
                    Snackbar.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            setResult(RESULT_OK)
            finish()
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
}
