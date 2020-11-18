db.createUser({
    user: "dnbuser",
    pwd: "dnbpassword1",
    roles: [{
            role: "readWrite",
            db: "dnb"
        }
    ]
});
