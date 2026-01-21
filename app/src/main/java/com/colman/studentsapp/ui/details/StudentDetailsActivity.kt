package com.colman.studentsapp.ui.details

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.colman.studentsapp.R
import com.colman.studentsapp.model.StudentRepository
import com.colman.studentsapp.ui.applyStatusBarInsetPadding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.snackbar.Snackbar

class StudentDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val toolbar: MaterialToolbar = findViewById(R.id.studentDetailsToolbar)
        // Ensure the toolbar is laid out below the system status bar / cutout.
        toolbar.applyStatusBarInsetPadding()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val studentUuid = intent.getStringExtra(EXTRA_STUDENT_UUID)
        val student = studentUuid?.let { StudentRepository.findByUuid(it) }

        val image: ShapeableImageView = findViewById(R.id.studentDetailsImage)
        val nameHeader: TextView = findViewById(R.id.studentDetailsName)
        val idHeader: TextView = findViewById(R.id.studentDetailsId)
        val nameValue: TextView = findViewById(R.id.studentDetailsNameValue)
        val idValue: TextView = findViewById(R.id.studentDetailsIdValue)
        val addressValue: TextView = findViewById(R.id.studentDetailsAddressValue)
        val checkedValue: TextView = findViewById(R.id.studentDetailsCheckedValue)
        val editButton: MaterialButton = findViewById(R.id.studentDetailsEditButton)

        if (student == null) {
            val notFound = getString(R.string.student_not_found)
            nameHeader.text = notFound
            idHeader.text = ""
            nameValue.text = notFound
            idValue.text = ""
            addressValue.text = ""
            checkedValue.text = ""
        } else {
            image.setImageResource(student.imageResId)
            nameHeader.text = student.name
            idHeader.text = getString(R.string.format_student_id_line, student.id)

            nameValue.text = student.name
            idValue.text = student.id
            addressValue.text = student.address
            checkedValue.text = if (student.isChecked) getString(R.string.value_yes) else getString(R.string.value_no)
        }

        editButton.setOnClickListener {
            try {
                val editIntent = Intent(this, Class.forName(EDIT_ACTIVITY_FQCN))
                editIntent.putExtra(EXTRA_STUDENT_UUID, studentUuid)
                startActivity(editIntent)
            } catch (_: Throwable) {
                Snackbar.make(editButton, getString(R.string.edit_screen_not_available), Snackbar.LENGTH_SHORT).show()
            }
        }
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
        private const val EDIT_ACTIVITY_FQCN = "com.colman.studentsapp.ui.edit.EditStudentActivity"
    }
}
