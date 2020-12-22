function convert(encrypted) {
    var key = 0x76;
    var str = '';
    for (var i = 0; i < encrypted.length; i++) {
        str += (String.fromCharCode(encrypted.charCodeAt(i) ^ key));
    }
    return str;
}
