package util;

public class LayuiTableData {

	public static final int FLAG_SUCCC=0;//����ɹ�
	public static final int FLAG_FAIL=1;//����ʧ��
	
	
	public int code;//������״̬
	public String msg;//������������Ϣ
	public int count;//�������ݵ�����
	public Object data;
	
	
	public LayuiTableData(){
		this.code = FLAG_FAIL;
		this.msg = null;
		this.count = 0;
		this.data = null;
		
	}
	
}
