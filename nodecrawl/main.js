const fs = require('fs');
const parse = require('csv-parse');
const async = require('async');
const request = require('request-promise-native');
const cheerio = require('cheerio');

const express = require('express');

const inputFile='Namskeid_2016_2017.csv';

let gogn = [];

let stagger = (index, max, data) => {
  console.log('Page start');
  // if (index >= max) {
  //   return;
  // }
  if (index >= 2) {
    console.log(gogn.length)
    return;
  }

  let dataPage = data.slice(index * 100, (index + 1) * 100);
  console.log(dataPage.length);

  Promise.all(
    dataPage.map((line) => {
      if (line[0] === 'Númer') {
        return;
      }
  
      getLongNumber(line[5]).then((langtNumer) => {
        gogn.push({
          numer: line[0],
          nafn: line[1],
          einingar: line[2],
          misseri: line[3],
          namsstig: line[4],
          urL: line[5],
          langtNumer,
        });
      });
    })
  ).then(() => {
    console.log('Page Done')
    setTimeout(() => {
      stagger(index+1, max, data);    
    }, 1000)
  })

};

var parser = parse({delimiter: ','}, function (err, data) {

  const pages = Math.ceil(data.length / 100);

  stagger(0, pages, data);


  // async.eachSeries(data, function (line, callback) {
  //   if (line[0] === 'Númer') {
  //     callback();
  //     return;
  //   }

  //   getLongNumber(line[5]).then((langtNumer) => {
  //     gogn.push({
  //       numer: line[0],
  //       nafn: line[1],
  //       einingar: line[2],
  //       misseri: line[3],
  //       namsstig: line[4],
  //       urL: line[5],
  //       langtNumer,
  //     });
  //     console.log('1')  
  //     callback();
  //   });
  // });


});

fs.createReadStream(inputFile).pipe(parser);


let getLongNumber = (url) => {
  return new Promise((resolve, reject) => {
    request(url).then((html) => {
      var $ = cheerio.load(html);
      var candidateList = $('.kennsluskra_item_container')
      let langtNumer;
      candidateList.each(function(i,elem) {
        if ($(this).text().includes('Langt námskeiðsnúmer')) {
          langtNumer = $(this).text().split(':')[1];
          return false;
        }
      });
      resolve(langtNumer);
    }).catch((e) => {
      console.log(e)
      reject()
    });
  });
}