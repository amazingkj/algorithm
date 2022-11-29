package codingTest;

public class HashTable3 {
	//Key-Value
	//Hash Function - Hash, Hash Value, Hash Address / Hash Table - Slot

		public Slot[] hashTable;
		
		public HashTable3(Integer size) {
			this.hashTable = new Slot[size];
			
		}
		
		public class Slot {
			String key;
			String value;
			Slot(String key, String value) {
				this.key=key;
				this.value=value;
			}
		}
		
		public int hashFunc(String Key) {
			return (int)(Key.charAt(0)) % this.hashTable.length;
		}
		
		public boolean saveData(String key, String value) {
			Integer address = this.hashFunc(key);
			if(this.hashTable[address] !=null) {
				if(this.hashTable[address].key==key) {
					this.hashTable[address].value=value;
					return true;
					
				}else {
					Integer currAddress=address+1;
					while (this.hashTable[currAddress] != null) {
						if(this.hashTable[currAddress].key == key) {
							this.hashTable[currAddress].value = value;
							return true;
						}else {
							currAddress++;
							if(currAddress >= this.hashTable.length) {
								return false;
							}
						}
					}
					
					this.hashTable[currAddress] = new Slot(key,value);
					return true;
				}
				
			}else {
				this.hashTable[address]=new Slot(key, value);
			}
			return true;
		}
		
		
		public String getData(String key) {
			Integer address =this.hashFunc(key);
			if(this.hashTable[address]!=null) {  			//�ش� �ּҿ� ���� ������ ������ 
				if(this.hashTable[address].key == key) { 	//���� ���̺� ���Կ� �ִ� Ű�� ���� ã�� Ű�� �´ٸ�
					return this.hashTable[address].value; 	//�ش�Ű�� ���� ����
				}else {										//�׷��� ������
					Integer currAddress = address +1;		//���� �������� �Ѿ��
					while (this.hashTable[currAddress] != null) {		//���� ������ null �� �ƴ϶��				
						if(this.hashTable[currAddress].key == key) {	//�ش� ������ ���� ã�� Ű���� Ȯ�� 
							return this.hashTable[currAddress].value;	//�´ٸ� �ش� ���� ����
						}else {											//�ٸ��ٸ� 
							currAddress++;								//�ٽ� ���� �ּҷ� 
							if(currAddress >= this.hashTable.length) {	//������ üũ�ߴٸ�
								return null;							//�����͸� �˻������� ���������� �ʴ´�. 
							}
						}
							
					}
					return null;
				}
				 
			}else {
				return null;
			}
			
		}

	
	
	public static void main(String[] args) {
		HashTable3 mainObject = new HashTable3(20);
		mainObject.saveData("DaveLee", "01022223333");
		mainObject.saveData("fun-coding", "01033334444");
		mainObject.saveData("Dave", "01065667777");
		mainObject.saveData("David", "01088889999");
		mainObject.saveData("Ddddd", "01099996666");
		System.out.println(mainObject.getData("Ddddd"));
		
	}

}
