function send() {
    var message = {};
    message.text = $("#message").val();
    message.author = $("#author").val();
    $.post("/profile/chatMessage", message, function () {
        $("#chatHistory").append().html(message.author + " : " + message.text + "\n");
    });
}