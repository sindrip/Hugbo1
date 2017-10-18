const fs = require('fs');
const {pool} = require('./pgPool.js');

const courses = JSON.parse(fs.readFileSync('courses.json', 'utf8'));

console.log(courses.length)


var addCourses = async (courses) => {
  let index = 0;

  const client = await pool.connect()
  var query = (text, params) => client.query(text, params);
  try {
    await query('DELETE FROM review where id = id');
    await query('DELETE FROM Course where nafn = nafn');

    for (let course of courses) {
      if (course.einingar.includes(',')) {
        course.einingar = course.einingar.replace(',', '.');
      }
      let result =  await query(`INSERT INTO Course (langt_numer, numer, nafn, einingar, kennslumisseri, namsstig, url)
                                 VALUES ($1, $2, $3, $4, $5, $6, $7)`, [course.langtnumer, course.numer, course.nafn, course.einingar,
                                               course.kennslumisseri, course.namstig, course.url]);
      console.log(++index, '/', courses.length);
    }

  } catch (e) {
    console.log(e);
  } finally {
    client.release()
    console.log('fin');
    pool.end();
  }
}

addCourses(courses);
