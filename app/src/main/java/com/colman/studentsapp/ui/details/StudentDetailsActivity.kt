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

    private var studentUuid: String? = null

    // Views kept as properties so we can update them from onResume
    private lateinit var image: ShapeableImageView
    private lateinit var nameHeader: TextView
    private lateinit var idHeader: TextView
    private lateinit var nameValue: TextView
    private lateinit var idValue: TextView
    private lateinit var addressValue: TextView
    private lateinit var checkedValue: TextView
    private lateinit var editButton: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)

        val toolbar: MaterialToolbar = findViewById(R.id.studentDetailsToolbar)
        // Ensure the toolbar is laid out below the system status bar / cutout.
        toolbar.applyStatusBarInsetPadding()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        studentUuid = intent.getStringExtra(EXTRA_STUDENT_UUID)

        image = findViewById(R.id.studentDetailsImage)
        nameHeader = findViewById(R.id.studentDetailsName)
        idHeader = findViewById(R.id.studentDetailsId)
        nameValue = findViewById(R.id.studentDetailsNameValue)
        idValue = findViewById(R.id.studentDetailsIdValue)
        addressValue = findViewById(R.id.studentDetailsAddressValue)
        checkedValue = findViewById(R.id.studentDetailsCheckedValue)
        editButton = findViewById(R.id.studentDetailsEditButton)

        editButton.setOnClickListener {
            try {
                val editIntent = Intent(this, Class.forName(EDIT_ACTIVITY_FQCN))
                editIntent.putExtra(EXTRA_STUDENT_UUID, studentUuid)
                startActivity(editIntent)
            } catch (_: Throwable) {
                Snackbar.make(
                    editButton,
                    getString(R.string.edit_screen_not_available),
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }

        // Initial populate
        populateFromRepository()
    }

    override fun onResume() {
        super.onResume()
        // Refresh the UI every time the activity resumes, so edits are reflected immediately
        populateFromRepository()
    }

    private fun populateFromRepository() {
        val student = studentUuid?.let { StudentRepository.findByUuid(it) }

        if (student == null) {
            // If the student was deleted
            finish()
            return
        } else {
            image.setImageResource(student.imageResId)
            nameHeader.text = student.name
            idHeader.text = getString(R.string.format_student_id_line, student.id)

            nameValue.text = student.name
            idValue.text = student.id
            addressValue.text = student.address
            checkedValue.text =
                if (student.isChecked) getString(R.string.value_yes) else getString(R.string.value_no)
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
