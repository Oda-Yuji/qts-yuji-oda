const mongoose = require('mongoose')

const Person = mongoose.model('Person', {
    name: String,
    slary: Number,
    approved: Boolean,
})

module.exports = Person
