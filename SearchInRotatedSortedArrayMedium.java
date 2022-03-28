package com.joka.mustdeletedservice;

public class SearchInRotatedSortedArrayMedium {

    public static void main(String[] args) {
        int[] nums = {2,2,2,3,2,2,2};
        SearchInRotatedSortedArrayMedium searchInRotatedSortedArrayMedium = new SearchInRotatedSortedArrayMedium();
        System.out.println(searchInRotatedSortedArrayMedium.search(nums, 3));
    }

    public boolean search(int[] nums, int target) {

        int pivotIndex = getPivotIndex(nums);
        int prevIndex = 0, nextIndex = nums.length - 1;

        if (pivotIndex != 0){
            if (nums[0] > target) {
                prevIndex = pivotIndex;
            } else if (nums[0] < target) {
                nextIndex = pivotIndex - 1;
            } else return true;
        }
        return searchNumber(target, nums, prevIndex, nextIndex);
    }

    public int getPivotIndex(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public boolean searchNumber(int target, int[] nums, int prevIndex, int nextIndex) {
        int middleIndex = (prevIndex + nextIndex) / 2;

        if (nums[prevIndex] == target || nums[nextIndex] == target){
            return true;
        }

        if (nextIndex - prevIndex == 2) {
            return nums[middleIndex] == target;
        }

        if (nums[middleIndex] > target) {
            nextIndex = middleIndex;
        } else if (nums[middleIndex] < target) {
            prevIndex = middleIndex;
        } else return true;

        return searchNumber(target, nums, prevIndex, nextIndex);
    }
}
//4,5,6,6,7,0,1,2,4,4