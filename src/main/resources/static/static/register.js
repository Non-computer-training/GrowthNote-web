$("#form").on("click", ".btn", function () {
  $.ajax({
    url: "/api/users",
    type: "POST",
    dataType: "json",
    contentType: 'application/json;charset=utf-8',
    data: JSON.stringify({"userName": $("#name").val(), "password": $("#password").val()}),
    success: function () {
        alert("注册成功");
        window.location.href = "../index.html"
    }
  })
})