function getSelectedSoftskill(variable) {
    var url = window.location.search.substring(1);
    var vars = url.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return decodeURI(pair[1]);}
    }
    return(false);
}

$(document)
    .ready(function () {
        $('.ui.dropdown').dropdown('set selected', getSelectedSoftskill('name'));
        var dropdown = document.getElementById( 'dropdown' );
        dropdown.onchange = function() {
            location.assign( './personalsoftskillform?name=' + this.options[ this.selectedIndex ].value, "self" );
        };

            $('.ui.form')
                .form({
                    fields: {
                        name: {
                            identifier: 'name',
                            rules: [
                                {
                                    type: 'empty',
                                    prompt: 'Please choose a softskill.'
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
    }
    );


