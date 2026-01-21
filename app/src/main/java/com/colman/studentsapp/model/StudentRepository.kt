package com.colman.studentsapp.model

import com.colman.studentsapp.R
import java.util.UUID

object StudentRepository {
    private fun newUuid(): String = UUID.randomUUID().toString()

    val students: MutableList<Student> = mutableListOf(
        Student(uuid = newUuid(), id = "100001", name = "Alex Johnson", address = "12 Maple St, Springfield", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100002", name = "Maya Chen", address = "45 Oak Ave, Riverdale", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100003", name = "Sam Rivera", address = "7 Pine Rd, Lakeside", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100004", name = "Noa Levi", address = "89 Cedar Blvd, Midtown", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100005", name = "Liam Patel", address = "3 Elm St, Hillview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100006", name = "Emma Cohen", address = "22 Birch Ln, Greenfield", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100007", name = "Daniel Kim", address = "101 Willow Dr, Brookside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100008", name = "Sophia Martinez", address = "16 Cherry Ct, Downtown", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100009", name = "Amit Singh", address = "58 Aspen Way, Northgate", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100010", name = "Olivia Brown", address = "9 Poplar St, West End", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100011", name = "Ethan Williams", address = "33 Magnolia Ave, Fairview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100012", name = "Ava Garcia", address = "74 Palm St, Seaside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100013", name = "Noah Davis", address = "6 Cypress Rd, Meadowbrook", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100014", name = "Mia Lopez", address = "40 Spruce Ln, Sunnyside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100015", name = "Ben Carter", address = "27 Walnut Dr, Parkview", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100016", name = "Zoe Adams", address = "15 Hickory Ct, Riverside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100017", name = "Yara Haddad", address = "92 Alder Ave, Eastwood", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100018", name = "Hana Suzuki", address = "11 Juniper St, Oakridge", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100019", name = "Omer Bar", address = "5 Olive Blvd, Central", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100020", name = "Ella Wilson", address = "63 Sycamore Rd, Harborview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100021", name = "Lea Friedman", address = "20 Chestnut Ln, Kingsway", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100022", name = "Ryan Moore", address = "8 Locust St, Old Town", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100023", name = "Nina Ivanova", address = "55 Rowan Ave, Midtown", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100024", name = "Tom Nguyen", address = "13 Redwood Dr, Valleyview", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100025", name = "Sara Khalil", address = "67 Sequoia Ct, North Hills", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100026", name = "Jack Thompson", address = "2 Fir St, Glenwood", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100027", name = "Lina Hassan", address = "84 Maple St, Cedar Grove", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100028", name = "Chris Lee", address = "29 Oak Ave, Riverdale", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100029", name = "Dana Rosen", address = "70 Pine Rd, Lakeside", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100030", name = "Victor Perez", address = "18 Cedar Blvd, Midtown", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100031", name = "Adi Shalev", address = "99 Elm St, Hillview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100032", name = "Isabella Rossi", address = "24 Birch Ln, Greenfield", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100033", name = "Mohammed Ali", address = "37 Willow Dr, Brookside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100034", name = "Grace Taylor", address = "10 Cherry Ct, Downtown", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100035", name = "Aria Cooper", address = "61 Aspen Way, Northgate", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100036", name = "Yonatan Levi", address = "4 Poplar St, West End", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100037", name = "Lily Scott", address = "31 Magnolia Ave, Fairview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100038", name = "Oren Cohen", address = "76 Palm St, Seaside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100039", name = "Iris Green", address = "14 Cypress Rd, Meadowbrook", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100040", name = "Kai Nakamura", address = "43 Spruce Ln, Sunnyside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100041", name = "Shira Dayan", address = "26 Walnut Dr, Parkview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100042", name = "Peter Novak", address = "19 Hickory Ct, Riverside", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100043", name = "Hila Ben-David", address = "90 Alder Ave, Eastwood", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100044", name = "Julia Anderson", address = "12 Juniper St, Oakridge", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100045", name = "Diego Silva", address = "7 Olive Blvd, Central", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100046", name = "Rina Gold", address = "64 Sycamore Rd, Harborview", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100047", name = "Henry Young", address = "21 Chestnut Ln, Kingsway", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100048", name = "Nora White", address = "9 Locust St, Old Town", isChecked = false, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100049", name = "Ariel Cohen", address = "56 Rowan Ave, Midtown", isChecked = true, imageResId = R.drawable.ic_person_24),
        Student(uuid = newUuid(), id = "100050", name = "Tal Mor", address = "15 Redwood Dr, Valleyview", isChecked = false, imageResId = R.drawable.ic_person_24),
    )

    fun findByUuid(uuid: String): Student? = students.firstOrNull { it.uuid == uuid }

    /**
     * Student ID is editable, so don't use it as a stable key.
     * Exists mainly for legacy code / display.
     */
    fun findById(id: String): Student? = students.firstOrNull { it.id == id }

    fun setAllChecked(isChecked: Boolean) {
        for (s in students) {
            s.isChecked = isChecked
        }
    }
}
