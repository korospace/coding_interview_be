function findIndex(nums,target) {
    let stop = false;

    // i = 7
    for (let i = 0; i < nums.length; i++) {
        
        // j = 15
        for (let j = i+1; j < nums.length; j++) {
            
            let total = nums[i] + nums[j];

            if (total == target) {
                console.log([i,j]);
                stop = true;
                break;
            }
            
        }

        if (stop) {
            break;
        }
        
    }

}

let nums   = [11,15,2,7];
let target = 9;

findIndex(nums,target);