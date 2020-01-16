$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    name: {
                        identifier: 'name',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a softskill.'
                            }
                        ]
                    },
                    description: {
                        identifier: 'description',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a description.'
                            }
                        ]
                    }

                }
            })
        ;

    })
;