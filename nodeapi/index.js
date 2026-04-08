const express = require('express')
const mongoose = require('mongoose')
const port = 3000
const app = express()

app.use(
    express.urlencoded({
        extended: true,
    }),
)

app.use(express.json())

const personRoutes = require('./router/personRouter')

app.use('/person', personRoutes)

app.get('/', (req, res) => {
    res.json({ message: 'Oi express' })
})

// mongodb+srv://yuji:clusterSenhaForte@cluster0.wwo0zy0.mongodb.net/?appName=Cluster0

const DB_USER = 'yuji'
const DB_PASSWORD = encodeURIComponent('clusterSenhaForte')

mongoose
    .connect(
        `mongodb+srv://${DB_USER}:${DB_PASSWORD}@cluster0.wwo0zy0.mongodb.net/?appName=Cluster0`,
    )
    .then(() => {
        console.log("Connectou com o MogoDB")
        app.listen(3000)
    })
    .catch((err) => console.log(err))
