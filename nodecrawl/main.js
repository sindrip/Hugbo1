const fs = require('fs');
const parse = require('csv-parse');
const request = require('request-promise-native');
const cheerio = require('cheerio');

const inputFile='Namskeid_2016_2017.csv';

let gogn = [];

var parser = parse({delimiter: ','}, async function (err, data) {
  let index = 0;
  const stepSize = 100;

  console.log(`Stepsize: ${stepSize} \n=================`);
  for (let i = 0; i < data.length / stepSize; i++) {
    let t = await stepMap(stepSize, i, data);
    console.log(i);
    console.log(gogn.length)
  }

  fs.writeFile('courses.json', JSON.stringify(gogn), (err) => {
    if (err) throw err;
    console.log('The file has been saved!');
  });
  
});

fs.createReadStream(inputFile).pipe(parser);

let stepMap = (stepSize, index, data) => {
  let newData = data.slice(1 + stepSize * index, 1 + stepSize * (index + 1));
  
  return Promise.all(
    newData.map((elem) => {
      return new Promise((resolve, reject) => {
        request(elem[5]).then((html) => {
          const longNumber = getLongNumber(html);

          pushToGogn(elem, longNumber);          

          resolve(longNumber);
        }).catch((e) => {
          console.log(e);
          reject();
        });
      })
    })
  );
}

let getLongNumber = (html) => {
  let $ = cheerio.load(html);
  let candidateList = $('.kennsluskra_item_container')
  let langtNumer;
  
  candidateList.each(function(i,elem) {
    if ($(this).text().includes('Langt námskeiðsnúmer')) {
      langtNumer = $(this).text().split(':')[1];
      return false;
    }
  });
  return langtNumer;
}

let pushToGogn = (elem, langtnumer) => {
  gogn.push({
    langtnumer,
    numer: elem[0].trim(),
    nafn: elem[1].trim(),
    einingar: elem[2].trim(),
    kennslumisseri: elem[3].trim(),
    namstig: elem[4].trim(),
    url: elem[5].trim(),
  })
};