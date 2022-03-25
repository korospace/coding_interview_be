function reverseNum(num) {
    let reverse  = "";
    let splitNum = [...num.toString()];

    for (let i = splitNum.length-1; i >= 0; i--) {
        reverse += splitNum[i];
    }

    return reverse;
}

function palindromeCheck(num) {
    if (num <= 0) {
        console.log(false);
    } else {
        console.log(num == reverseNum(num));
    }
}

palindromeCheck(121); // true
palindromeCheck(-121); // false