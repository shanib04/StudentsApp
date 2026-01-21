package com.colman.studentsapp.model

import com.colman.studentsapp.R
import java.util.UUID

object StudentRepository {
    private fun newUuid(): String = UUID.randomUUID().toString()

    // expose a public helper for activities that need to create a new student uuid
    fun newUuidPublic(): String = newUuid()

    val students: MutableList<Student> = mutableListOf(
        Student(
            uuid = newUuid(),
            id = "100001",
            name = "Alex Johnson",
            address = "12 Maple St, Springfield",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100002",
            name = "Maya Chen",
            address = "45 Oak Ave, Riverdale",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100003",
            name = "Sam Rivera",
            address = "7 Pine Rd, Lakeside",
            isChecked = true,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100004",
            name = "Noa Levi",
            address = "89 Cedar Blvd, Midtown",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100005",
            name = "Liam Patel",
            address = "3 Elm St, Hillview",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100006",
            name = "Emma Cohen",
            address = "22 Birch Ln, Greenfield",
            isChecked = true,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100007",
            name = "Daniel Kim",
            address = "101 Willow Dr, Brookside",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100008",
            name = "Sophia Martinez",
            address = "16 Cherry Ct, Downtown",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100009",
            name = "Amit Singh",
            address = "58 Aspen Way, Northgate",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100010",
            name = "Olivia Brown",
            address = "9 Poplar St, West End",
            isChecked = true,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100011",
            name = "Ethan Williams",
            address = "33 Magnolia Ave, Fairview",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100012",
            name = "Ava Garcia",
            address = "74 Palm St, Seaside",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100013",
            name = "Noah Davis",
            address = "6 Cypress Rd, Meadowbrook",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100014",
            name = "Mia Lopez",
            address = "40 Spruce Ln, Sunnyside",
            isChecked = false,
            imageResId = R.drawable.ic_person_24
        ),
        Student(
            uuid = newUuid(),
            id = "100015",
            name = "Ben Carter",
            address = "27 Walnut Dr, Parkview",
            isChecked = true,
            imageResId = R.drawable.ic_person_24
        ),
    )

    fun findByUuid(uuid: String): Student? = students.firstOrNull { it.uuid == uuid }

    fun findById(id: String): Student? = students.firstOrNull { it.id == id }

    fun setAllChecked(isChecked: Boolean) {
        for (s in students) {
            s.isChecked = isChecked
        }
    }

    // Create a new student - returns the created Student or null if the ID already exists
    fun createStudent(
        id: String,
        name: String,
        address: String,
        isChecked: Boolean,
        imageResId: Int
    ): Student? {
        if (findById(id) != null) return null
        val student = Student(
            uuid = newUuid(),
            id = id,
            name = name,
            address = address,
            isChecked = isChecked,
            imageResId = imageResId
        )
        students.add(student)
        return student
    }

    // Update result codes for updateByUuid
    enum class UpdateResult {
        SUCCESS,
        NOT_FOUND,
        DUPLICATE_ID
    }

    // Atomically update a student identified by uuid. Returns UpdateResult.
    fun updateByUuid(
        uuid: String,
        newId: String,
        newName: String,
        newAddress: String,
        newChecked: Boolean
    ): UpdateResult {
        val student = findByUuid(uuid) ?: return UpdateResult.NOT_FOUND
        if (newId != student.id) {
            // If another student already uses newId, block the change
            val existing = findById(newId)
            if (existing != null) return UpdateResult.DUPLICATE_ID
        }
        student.id = newId
        student.name = newName
        student.address = newAddress
        student.isChecked = newChecked
        return UpdateResult.SUCCESS
    }

    // Delete by UUID - return true if removed and false if not found
    fun deleteByUuid(uuid: String): Boolean {
        val it = students.iterator()
        while (it.hasNext()) {
            if (it.next().uuid == uuid) {
                it.remove()
                return true
            }
        }
        return false
    }
}
