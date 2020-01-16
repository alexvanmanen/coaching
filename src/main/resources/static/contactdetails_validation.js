$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
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
                    }
                }
            })
        ;

    })
;