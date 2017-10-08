package org.clay.Chap2;

/**
 * 荷兰国旗问题：时间复杂度O(n), 空间复杂度o(1)
 * 
 * 0,1,2, 0在左边，1在中间，2在右边
 * 
 * @author clay
 */
public class DutchFlag {

	private void swap(int[] array, int begin, int end) {
		int temp = array[begin];
		array[begin] = array[end];
		array[end] = temp;
	}

	/**
	 * 我们可以把数组分成三部分，前部（全部是0），中部（全部是1）和后部（全部是2）三个部分，每一个元素（红白蓝分别对应0、1、2）必属于其中之一。
	 * 将前部和后部各排在数组的前边和后边，中部自然就排好了。
	 * 设置两个指针begin指向前部的末尾的下一个元素（刚开始默认前部无0，所以指向第一个位置），
	 * end指向后部开头的前一个位置（刚开始默认后部无2，所以指向最后一个位置），然后设置一个遍历指针current，从头开始进行遍历。
	 * 
	 * （1）若遍历到的位置为1，则说明它一定属于中部，根据总思路，中部的我们都不动，然后current向前移动一个位置。
	 * （2）若遍历到的位置为0，则说明它一定属于前部，于是就和begin位置进行交换，然后current向前移动一个位置，
	 * begin也向前移动一个位置,因为begin指向的永远是前面0部分的下一个元素。
	 * 这里current会向前移动的原因是前面只有0或者1,当cur指向0时，都得向后走，指向1时, cur往后走。
	 * （3）若遍历到的位置为2，则说明它一定属于后部，于是就和end位置进行交换，由于交换完毕后current指向的可能是属于前部的，
	 * 若此时current前进则会导致该位置不能被交换到前部，所以此时current不前进。而同1），end向前移动一个位置。
	 */
	public void dutchFlag(int[] array, int n) {

		int begin = 0;
		int end = n - 1;
		int cur = 0;

		while (cur <= end) {
			if (array[cur] == 0) {
				swap(array, begin, cur);
				begin++;
				cur++;
			} else if (array[cur] == 1) {
				cur++;
			} else {
				swap(array, end, cur);
				end--;
			}
		}
	}

	/**
	 * （1）遍历数组，统计红白蓝三色球（0，1，2）的个数 
	 * （2）根据红白蓝三色球（0，1，2）的个数重排数组 
	 *  时间复杂度：O(n)
	 */
	public void dutchFlag1(int[] array, int n) {

		int red = 0;
		int white = 0;
		int blue = 0;

		for (int i = 0; i < n; i++) {
			if (array[i] == 0) {
				++red;
			}else if (array[i] == 1) {
				++white;
			}else {
				++blue;
			} 
		}
		// 重新布局  
		for(int i = 0;i < n;++i){  
            if(red > 0){  
            	array[i] = 0;  
                --red;  
            }else if(white > 0){  
            	array[i] = 1;  
                --white;  
            }else{  
            	array[i] = 2;  
            }  
        } 
	}

	public static void main(String[] args) {
		DutchFlag df = new DutchFlag();
		int[] array = new int[] { 0, 1, 2, 1, 0, 2, 2 };
		df.dutchFlag1(array, array.length);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
