const express = require('express')
const mongoose = require('mongoose')
const app = express()

const Person = require('./models/Person')

app.use(
    express.urlencoded({
        extended: true,
    }),
)

app.use(express.json())

app.post('/person', async(req, res) => {
    const {name, slary, approved} = req.body

    const person = {
        name,
        slary,
        approved
    }

    try {
        await Person.create(person)

        res.statu(201).json({ message: 'Pessoa inserida no sistema com sucesso' })

    } catch (error) {
        res.status(500).json({ error: error })
    }
})

app.get('/', (req, res) => {
    res.json({ message: 'Oi express' })
})

// clusterSenhaForte

// mongodb+srv://yuji:clusterSenhaForte@cluster0.wwo0zy0.mongodb.net/?appName=Cluster0
const DB_USER = 'yuji'
const DB_PASSWORD = encodeURIComponent('clusterSenhaForte')

mongoose
    .connect(
        `mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster0.wwo0zy0.mongodb.net/?appName=Cluster0`
    )
    .then(() => {
        console.log("Connectou com o MogoDB")
        app.listen(3000)
    })
    .catch((err) => console.log(err))

app.listen(3000)