package com.colman.studentsapp.model

import com.colman.studentsapp.R

object StudentRepository {
    val students: MutableList<Student> = mutableListOf(
        Student(id = "100001", name = "Alex Johnson", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100002", name = "Maya Chen", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100003", name = "Sam Rivera", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100004", name = "Noa Levi", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100005", name = "Liam Patel", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100006", name = "Emma Cohen", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100007", name = "Daniel Kim", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100008", name = "Sophia Martinez", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100009", name = "Amit Singh", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100010", name = "Olivia Brown", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100011", name = "Ethan Williams", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100012", name = "Ava Garcia", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100013", name = "Noah Davis", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100014", name = "Mia Lopez", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100015", name = "Ben Carter", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100016", name = "Zoe Adams", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100017", name = "Yara Haddad", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100018", name = "Hana Suzuki", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100019", name = "Omer Bar", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100020", name = "Ella Wilson", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100021", name = "Lea Friedman", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100022", name = "Ryan Moore", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100023", name = "Nina Ivanova", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100024", name = "Tom Nguyen", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100025", name = "Sara Khalil", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100026", name = "Jack Thompson", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100027", name = "Lina Hassan", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100028", name = "Chris Lee", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100029", name = "Dana Rosen", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100030", name = "Victor Perez", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100031", name = "Adi Shalev", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100032", name = "Isabella Rossi", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100033", name = "Mohammed Ali", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100034", name = "Grace Taylor", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100035", name = "Aria Cooper", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100036", name = "Yonatan Levi", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100037", name = "Lily Scott", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100038", name = "Oren Cohen", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100039", name = "Iris Green", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100040", name = "Kai Nakamura", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100041", name = "Shira Dayan", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100042", name = "Peter Novak", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100043", name = "Hila Ben-David", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100044", name = "Julia Anderson", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100045", name = "Diego Silva", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100046", name = "Rina Gold", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100047", name = "Henry Young", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100048", name = "Nora White", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(id = "100049", name = "Ariel Cohen", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(id = "100050", name = "Tal Mor", isChecked = false, imageResId = R.drawable.ic_person_24),
    )

    fun findById(id: String): Student? = students.firstOrNull { it.id == id }

    fun setAllChecked(isChecked: Boolean) {
        for (s in students) {
            s.isChecked = isChecked
        }
    }
}
