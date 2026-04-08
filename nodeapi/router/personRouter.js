const router = require('express').Router()

router.post('/', async(req, res) => {
    const {name, slary, approved} = req.body

    if(!name) {
        res.status(422).json({ error: 'O nome é obrigatório' })
    }

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

module.exports = router