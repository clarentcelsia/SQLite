package com.example.sqlite_saving_data

// CREATE CLASS STUDENT
class Student {

    var id : String? = null
    var name : String? = null
    var gender : String? = null
    var phone : String? = null

    constructor(id: String, name: String?, gender: String?, phone: String?) {
        this.id = id
        this.name = name
        this.gender = gender
        this.phone = phone
    }


}

//var = variable bisa diganti
//val = final
//lateinit = nullable type