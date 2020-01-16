$(document)
    .ready(function () {
        $('.ui.form')
            .form({
                fields: {
                    coursename: {
                        identifier: 'coursename',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a course.'
                            }
                        ]
                    },
                    coursedescription: {
                        identifier: 'coursedescription',
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