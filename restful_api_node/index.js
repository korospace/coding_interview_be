const express = require('express');
const app     = express();
const port    = 5000;
const db      = require('./queries');

app.use(express.json());
app.use(express.urlencoded({ extended: false }));

app.get('/products/', db.getProducts);
app.get('/products/:id', db.getProductById);
app.post('/products/', db.createProduct);
app.put('/products/:id', db.updateProduct);
app.delete('/products/:id', db.deleteProduct);

app.get("/", (req,res) => {
  return res.status(200).send({
    get:`localhost:${port}/products`,
    post:`localhost:${port}/products`,
    put:`localhost:${port}/products/id`,
    delete:`localhost:${port}/products/id`,
  })
})

app.listen(port, () => {
  console.log(`Api is running on port ${port}.`);
});