db.createUser(
    {
        user:"prueba",
        pwd:"1234",
        roles:[{
            role:"atlasAdmin",
            db:"Cluster0"
        }]
    }
)
