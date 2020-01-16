$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    new_password: {
                        identifier: 'new_password',
                        rules: [
                            {   type: 'regExp[/^\\S[\\S]+\\S$/]',
                                prompt: 'Your password must NOT contain any spaces'

                            },
                            {   type: 'regExp[.*[A-Z]]',
                                prompt: 'Your password must at least contain 1 capital'

                            },
                            {   type: 'regExp[(.*[0-9]){2}]',
                                prompt: 'Your password must at least contain 2 digits'

                            },
                            {   type: 'regExp[(.*[!@#$%^&]){2}]',
                                prompt: 'Your password must at least contain 2 special characters (!@#$%^&)'

                            },
                            {
                                type: 'regExp[.{10,}]',
                                prompt: 'Your password must at least 10 characters long'
                            }
                        ]
                    },
                    confirm_password: {
                        identifier: 'confirm_password',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please confirm your new password'
                            },
                            {
                                type: 'match[new_password]',
                                prompt: 'Your password confirmation does not match your new password'
                            }
                        ]
                    }
                }
            })
        ;

    })
;