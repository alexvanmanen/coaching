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
                                prompt: 'Please enter a hardskill.'
                            }
                        ]
                    },
                    state: {
                        identifier: 'state',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please choose a status.'
                            }
                        ]
                    },
                    start: {
                        identifier: 'start',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a start date.'
                            },
                            {
                                type: 'regExp[([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))]',
                                prompt: 'Start date should be in the format YYYY-MM-DD.'
                            }
                        ]
                    },
                    end: {
                        identifier: 'end',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a stop date.'
                            },
                            {
                                type: 'regExp[([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))]',
                                prompt: 'End date should be in the format YYYY-MM-DD.'
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
                    },
                    report: {
                        identifier: 'report',
                        rules: [
                            {
                                type: 'empty',
                                prompt: 'Please enter a report.'
                            }
                        ]
                    }
                }
            })
        ;

    })
;