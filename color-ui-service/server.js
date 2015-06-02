var http = require('http'),
    express = require('express'),
    colorServiceConsumer = require('./app/colorServiceConsumer'),
    errorHandler = require('errorhandler');

var app = module.exports = express();
var server = http.createServer(app);

// Configuration
app.set('views', __dirname + '/views');
app.set('view engine', 'jade');
app.set('view options', {
    layout: false
});
app.use(require('body-parser')());
app.use(require('method-override')());
app.use(require('express-promise')());
app.use(express.static(__dirname + '/public'));

var env = process.env.NODE_ENV || 'development';
if ('development' == env) {
    app.use(errorHandler({dumpExceptions: true, showStack: true}));
}
if ('production' == env) {
    app.use(errorHandler());
}

// Routes
app.get('/color', function (req, res) {
    res.json(colorServiceConsumer.color());
});

app.get('*', function (req, res) {
    res.render('index');
});

// Start server
//server.listen(8085);
server.listen(80);