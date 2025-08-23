const express = require('express');
const path = require('path');
const fs = require('fs');

const PORT = process.env.PORT || 3001;
const app = express();

// Serve static files from the React build directory
app.use(express.static(path.resolve(__dirname, 'build')));

// Serve index.html for all routes (CSR fallback)
app.get('*', (req, res) => {
  fs.readFile(path.resolve('./build/index.html'), 'utf8', (err, data) => {
    if (err) {
      return res.status(500).send('Error loading index.html');
    }
    return res.send(data);
  });
});

app.listen(PORT, () => {
  console.log(`React static server running on port ${PORT}`);
});
