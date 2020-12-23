function convert(encrypted,key) {
    var str = '';
    for (var i = 0; i < encrypted.length; i++) {
        str += (String.fromCharCode(encrypted.charCodeAt(i) ^ key));
    }
    return str;
}
