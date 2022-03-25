function findIndex(nums,target) {
    let stop = false;

    for (let i = 0; i < nums.length; i++) {
        
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

let nums   = [2,7,15,11];
let target = 17;

findIndex(nums,target);