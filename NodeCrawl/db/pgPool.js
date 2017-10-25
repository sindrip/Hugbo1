require('./../config/config.js');

const pg = require('pg');

const connectionString = process.env.DATABASE_URL;

const { Pool } = pg;
const pool = new Pool({
  connectionString,
});

module.exports.pool = pool;
module.exports.query = (text, params) => pool.query(text, params);