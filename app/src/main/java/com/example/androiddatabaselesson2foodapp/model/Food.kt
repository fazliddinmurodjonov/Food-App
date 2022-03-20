package com.example.androiddatabaselesson2foodapp.model

class Food {
    var id: Int? = null
    var name: String? = null
    var products: String? = null
    var prepare: String? = null

    constructor(id: Int?, name: String?, products: String?, prepare: String?) {
        this.id = id
        this.name = name
        this.products = products
        this.prepare = prepare
    }

    constructor(name: String?, products: String?, prepare: String?) {
        this.name = name
        this.products = products
        this.prepare = prepare
    }

}