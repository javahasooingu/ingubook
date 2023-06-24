$(()=>{
    $("")
    $("#idCheck").on({
        click : function (){
            let loninId = $(".loginId").val();

            checkDuplicateId(loninId);
        }
    })

    $("#phoneCheck").on({
        click : function (){
            let phoneNumber = $(".phoneNumber").val();

            checkDuplicatePhoneNumber(phoneNumber);
        }
    })
    $("#signUp").on({
        click : function () {

        }
    })
})

var checkDuplicateId = function(loninId){
    $.ajax({
        type: "POST",
        url: "/user/id-check",
        data:{
            'loginId' : loninId
        },
        error: function (msg) {
            alert(msg.toString())
        },
        success: function (msg) {
            alert(msg)
            $("#idCheckValue").attr("value", true)
        }
    });
}
var checkDuplicatePhoneNumber = function(phoneNumber) {
    $.ajax({
        type: "POST",
        url: "/user/id-phone",
        data:{
            'loginId' : phoneNumber
        },
        error: function (msg) {
            alert(msg)
        },
        success: function (msg) {
            alert(msg)
        }
    });
}
var checkEqualPassword = function () {
    if($("password").val() !== $("passwordConfirm").val()){
        return "비밀번호가 일치하지 않습니다";
    }
    return "확인";
}
var signUp = function (formData) {
    $.ajax({
        type: "POST",
        url: "/user/sing-up",
        data:{

        }
    })
}