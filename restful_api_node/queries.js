const Pool = require('pg').Pool;

const pool = new Pool({
  user: 'aileqcgqngmlju',
  host: 'ec2-18-215-96-22.compute-1.amazonaws.com',
  database: 'ddohsfmcf0too',
  password: 'fca89bfb300234c85c93d212b2fbb059bc13c5e143101c3ed314d6852090fad7',
  port: 5432,
  ssl: {
    rejectUnauthorized: false
  }
});

function formatingRes(code,data="") {
  let res = {
    code,
    status: (code <= 300) ? "success" : "failed"
  };

  if (code <= 300) {
    res["data"] = data
  } else {
    res["message"] = data
  }

  if (code == 202) {
    delete res["data"];
  }

  return res;
}

/**
 * List product
 */
const getProducts = (req, res) => {
  pool.query('SELECT * FROM products ORDER BY id ASC', (error, results) => {
    if (error) {
      return res.status(500).send(formatingRes(500,"anda tidak bisa mengakses server!"))      
    }
    else if (results.rows.length == 0) {
      return res.status(200).send(formatingRes(404,"products not found"))      
    } 
    else {
      return res.status(200).send(formatingRes(200,results.rows))
    }
  })
}

/**
 * Get product by ID
 */
const getProductById = (req, res) => {
  const id = req.params.id

  pool.query('SELECT * FROM products WHERE id = $1', [id], (error, results) => {
    if (error) {
      return res.status(500).send(formatingRes(500,error))      
    }
    else if (results.rows.length == 0) {
      return res.status(404).send(formatingRes(404,`product with ID: ${id} is not found`))      
    } 
    else {
      return res.status(200).send(formatingRes(200,results.rows[0]))
    }
  })
}

/**
 * Create product
 */
const createProduct = (req, res) => {
  const { id, name, price, quantity } = req.body;

  const created_at = new Date().toISOString();
  const updated_at = new Date().toISOString();

  pool.query(
    'INSERT INTO products (id, name, price, quantity, created_at, updated_at) VALUES ($1, $2, $3, $4, $5, $6)', 
    [id, name, price, quantity, created_at, updated_at], 
    (error, results) => {
      if (error) {
        return res.status(500).send(formatingRes(500,error));
      }

      let data = {
        id,name,price,quantity,created_at,updated_at
      }

      return res.status(201).send(formatingRes(201,data))
    }
  )
}

/**
 * Update product
 */
const updateProduct = (req, response) => {
  const id = req.params.id
  const { name, price, quantity } = req.body
  const updated_at = new Date().toISOString();

  pool.query(
    'UPDATE products SET name = $1, price = $2, quantity = $3, updated_at = $4 WHERE id = $5',
    [name, price, quantity, updated_at, id],
    (error, results) => {
      if (error) {
        return res.status(500).send(formatingRes(500,error));
      }
      else {
        let data = {
          id,name,price,quantity,updated_at
        }

        return response.status(200).send(formatingRes(200,data))
      }
    }
  )
}

/**
 * Delete product
 */
const deleteProduct = (req, res) => {
  const id = req.params.id

  pool.query('DELETE FROM products WHERE id = $1', [id], (error, results) => {
    if (error) {
      return res.status(500).send(formatingRes(500,error));
    }
    else if (results.rowCount == 0) {
      return res.status(404).send(formatingRes(404,`product with ID: ${id} is not found`))
    } 
    else {
      return res.status(202).send(formatingRes(202))
    }
  })
}

// exporting
module.exports = {
  formatingRes,
  getProducts,
  getProductById,
  createProduct,
  updateProduct,
  deleteProduct
}