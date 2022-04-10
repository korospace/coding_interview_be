function reverseNum(num) {
    let reverse  = "";
    let splitNum = [...num.toString()];

    for (let i = splitNum.length-1; i >= 0; i--) {
        reverse += splitNum[i];
    }

    return reverse;
}

function palindromeCheck(num) {
    if (num <= 0) { // jika negative
        return false;
    } else {
        return num == reverseNum(num);
    }
}

let arr = [2324,-141,212,100,1001,"1001"];

arr.forEach(e => {
    console.log(palindromeCheck(e));;
});

// palindromeCheck(121); // true
// palindromeCheck(-121); // false