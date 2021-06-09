const http = require('http');

const requestListener = (request, response) => {
    response.setHeader('Content-Type', 'text/html');

    response.statusCode = 200;
    response.end('<h1>Http Server menggunakan NodeJS!</h1>');
};

const server = http.createServer(requestListener);

const port = 4000;
const host = 'localhost';

server.listen(port, host, () => {
    console.log('Web Server berjalan pada http://${host}:${port}');
});