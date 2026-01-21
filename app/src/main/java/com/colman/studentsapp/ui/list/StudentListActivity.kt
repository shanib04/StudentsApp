package com.colman.studentsapp.ui.list

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.colman.studentsapp.R
import com.colman.studentsapp.model.StudentRepository
import com.colman.studentsapp.ui.applyStatusBarInsetPadding
import com.colman.studentsapp.ui.details.StudentDetailsActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

class StudentListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val toolbar: MaterialToolbar = findViewById(R.id.studentListToolbar)
        // Ensure the toolbar is laid out below the system status bar / cutout.
        toolbar.applyStatusBarInsetPadding()
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.studentListRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter(
            students = StudentRepository.students,
            onStudentClick = { student ->
                val intent = Intent(this, StudentDetailsActivity::class.java)
                intent.putExtra(StudentDetailsActivity.EXTRA_STUDENT_UUID, student.uuid)
                startActivity(intent)
            },
            onCheckedChanged = { student, isChecked ->
                student.isChecked = isChecked
            }
        )
        recyclerView.adapter = adapter

        findViewById<View>(R.id.studentListFab).setOnClickListener {
            try {
                val addIntent = Intent(
                    this,
                    Class.forName("com.colman.studentsapp.ui.create.NewStudentActivity")
                )
                startActivity(addIntent)
            } catch (_: Throwable) {
                Snackbar.make(
                    recyclerView,
                    "Add Student screen not available",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.submitList(StudentRepository.students)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_student_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_select_all -> {
                StudentRepository.setAllChecked(true)
                adapter.submitList(StudentRepository.students)
                true
            }

            R.id.action_deselect_all -> {
                StudentRepository.setAllChecked(false)
                adapter.submitList(StudentRepository.students)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}
