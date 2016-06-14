/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function ricerca()
{
    var stringa = document.getElementById("ricerca").value;
    if (stringa != undefined)
    {
        $.ajax  ({
                        url: "filter.json",
                        type: 'GET',
                        data:{ q: stringa},
                        dataType: 'json',
                        success : function(data, state){aggiornaTabella(data);},
                        error : function(data, state){}
                });
    }
    
}

function aggiornaTabella(tabella)
{   
    $("tr").show();
    for (var i = 0; i < tabella.length; i++)
    {
        var a = tabella[i].id;
        var stringa = "tr." + a ;
        $(stringa).hide();
        
    }
function controllaTabelRow()
{
    
    
}
}

