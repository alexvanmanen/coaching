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
                    street: {
                        identifier: 'street',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a street.'
                            }
                        ]
                    },
                    streetNr: {
                        identifier: 'streetNr',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a street number'
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
                    zipcode: {
                        identifier: 'zipcode',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a zipcode.'
                            }
                        ]
                    },
                    telephonenr: {
                        identifier: 'telephonenr',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a telephone number.'
                            }
                        ]
                    },
                    city: {
                        identifier: 'city',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a city.'
                            }
                        ]
                    },
                    country: {
                        identifier: 'country',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please choose you country.'
                            }
                        ]
                    },
                    dateofbirth: {
                        identifier: 'dateofbirth',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a date of birth.'
                            },
                            {
                                type: 'regExp[([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))]',
                                prompt: "Date of birth has to have entered as YYYY-MM-DD."
                            }
                        ]
                    }
                }
            })
        ;

    })
;