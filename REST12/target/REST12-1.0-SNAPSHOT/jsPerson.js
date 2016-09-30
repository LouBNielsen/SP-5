
$(document).ready(function ()
{
    $("#PersonAdd").click(function ()
    {
        PersonAdd();
        $('#TablePersons tbody').append('<tr><td>' + $("#PersonFirstName").val() + '</td><td>' + $("#PersonFirstName").val() + '</td><td>' + $("#PersonLastName").val() + '</td><td>' + $("#PersonPhoneNumber").val() + '</td></tr>');
        
    });
});


function PersonAdd()
{
    //var person = "{fName: " + $("#PersonFirstName").val() + ", lName: " + $("#PersonLastName").val() + ", phone: " + $("#PersonPhoneNumber").val() + " }";
   var test = "{\"fName\" : \"Louise\", \"lName\" : \"Mortensen\", \"phone\" : \"11325569\"}";
    console.log(test);
    $.ajax({
        url: "http://localhost:8080/REST12/api/person/add",
        type: "POST",
        data: JSON.stringify(test),
        crossDomin: true,
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function () {
            console.log("success");
        },
        error: function()
        {
            console.log("error");
        }
    });
}

function Person(first, last, phone)
{
    this.fName = first;
    this.lName = last;
    this.phone = phone;
    this.fullName = function () {
        return this.fName + " " + this.lName;
    };
}