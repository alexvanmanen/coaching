$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    username: {
                        identifier: 'username',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter an username.'
                            }
                        ]
                    },
                    password: {
                        identifier: 'password',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a password.'
                            }
                        ]
                    },
                    firstname: {
                        identifier: 'firstname',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a first name.'
                            }
                        ]
                    },
                    lastname: {
                        identifier: 'lastname',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a last name.'
                            }
                        ]
                    },
                    email: {
                        identifier: 'email',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a email.'
                            },
                            {
                                type: 'regExp[^[a-zA-Z0-9.!#$%&\'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$]',
                                prompt: 'Please enter a legit email. (Example: bob@bob.com)'
                            }
                        ]
                    },
                    roles: {
                        identifier: 'roles',
                        rules: [
                            {
                                type: 'checked',
                                prompt: 'Please choose a role'
                            }
                        ]
                    }
                }
            })
        ;

    })
;