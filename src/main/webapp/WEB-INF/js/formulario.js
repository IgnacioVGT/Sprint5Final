$(document).ready(function(){    

    $("input[type='radio']").click(function(){
        switch(this.id){
            case "cliente":
                $("#Cliente").removeClass("oculto");
                $("#Profesional").addClass("oculto");
                $("#Administrativo").addClass("oculto");
                break;
            case "profesional":
                $("#Profesional").removeClass("oculto");
                $("#Cliente").addClass("oculto");
                $("#Administrativo").addClass("oculto");
                break;
            case "administrativo":
                $("#Administrativo").removeClass("oculto");
                $("#Cliente").addClass("oculto");
                $("#Profesional").addClass("oculto");
                break;
        }
    });
});