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
// app.get("*", (req,res) => {
//   return response.status(404).send(db.formatingRes(404,"url not found"))
// })

app.listen(port, () => {
  console.log(`Api is running on port ${port}.`);
});