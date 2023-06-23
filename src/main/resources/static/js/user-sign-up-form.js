$(()=>{
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
            let messages = Array();

            messages.push();

            alert(messages.toString());
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
        error: function () {
            alert("중복된 ID가 있습니다.")
        },
        success: function () {

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
        error: function () {
            alert("이미 가입한 번호입니다.")
        },
        success: function () {

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