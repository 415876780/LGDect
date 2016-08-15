package ccnu.com.org;
//

import java.util.*;

import java.awt.*;

import java.awt.Color;
import javax.swing.*;
import javax.swing.text.*;


public class TextDisplayer extends JScrollPane
{
    JTextPane editor = null;
    StyleContext sc = null;
    DefaultStyledDocument doc = null;

    HashMap styles = null;

    public TextDisplayer()
    {
        super();
        init();
    }

    public void init()
    {
        styles = new HashMap();

        sc = new StyleContext();
        doc = new DefaultStyledDocument(sc);

        editor = new JTextPane(doc);
        editor.setDragEnabled(true);
        editor.setFont(new Font("monospaced", Font.PLAIN, 12));

        JViewport port = getViewport();
        port.add(editor);
        port.setBackingStoreEnabled(true);

        initStyles();
    }

    public void initStyles()
    {
        //������
        Style s = sc.addStyle(null, null);
        styles.put("none", s);

        //����
        s = sc.addStyle(null, null);
        StyleConstants.setForeground(s, Color.black);
        StyleConstants.setBackground(s, Color.white);
        StyleConstants.setAlignment(s, StyleConstants.ALIGN_LEFT);
        //StyleConstants.setFirstLineIndent(s, 12);
        styles.put("Paragraph", s);
    }

    public void appendText(String content, Color color, Color bgColor)
    {
        Style s = sc.addStyle(null, null);
        StyleConstants.setForeground(s, color);
        StyleConstants.setBackground(s, bgColor);

        try
        {
            doc.insertString(doc.getLength(), content, s);
        } catch(BadLocationException e)
        {
        }
    }

    public void insertText(int pos, String content, Color color, Color bgColor)
 {
		Style s = sc.addStyle(null, null);
		StyleConstants.setForeground(s, color);
		StyleConstants.setBackground(s, bgColor);

		if (pos < doc.getLength()) {
			try {
				doc.insertString(pos, content, s);
			} catch (Exception e) {
			}
		} else {
			try {
				doc.insertString(doc.getLength(), content, s);
			} catch (BadLocationException e) {
			}
		}
	}

    public void appendText(String content, String style)
    {
        Style s = (Style)styles.get(style);
        if (null == s)
        {
            s = (Style)styles.get("none");
        }

        try
        {
            doc.insertString(doc.getLength(), content, s);
        } catch(BadLocationException e)
        {
        }
    }

    public void appendText(String content)
    {
        Style s = (Style)styles.get("none");
        try
        {
            doc.insertString(doc.getLength(), content, s);
        } catch(BadLocationException e)
        {
            e.printStackTrace(System.err);
        }
    }

    public void setText(String content)
    {
        Style s = (Style)styles.get("none");

        try
        {
            doc.remove(0, doc.getLength());
            doc.insertString(doc.getLength(), content, s);
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    public void appendNullLine()
    {
        try
        {
            doc.insertString(doc.getLength(), "\n", null);
        } catch(BadLocationException e)
        {
        }
    }

    //���������ı�������ɫ
    public void setColor(String[] texts, Color color, Color bgColor)
    {
        String content = null;
        try
        {
            content = getText();
        } catch(Exception e)
        {
            return;
        }

        int pos = -1;

        Style s = sc.addStyle(null, null);
        StyleConstants.setForeground(s, color);
        StyleConstants.setBackground(s, bgColor);

        try
        {
            for (int i = 0; i < texts.length; i ++)
            {
                pos = content.indexOf(texts[i]);
                while (-1 != pos)
                {
                    doc.remove(pos, texts[i].length());
                    doc.insertString(pos, texts[i], s);

                    pos = content.indexOf(texts[i], pos + 1);
                }
            }
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    //���������ı�������ɫ
    public void setTextColor(String text, Color color, Color bgColor)
    {
        String content = null;
        try
        {
            content = getText();
        } catch(Exception e)
        {
            return;
        }

        int pos = -1;

        Style s = sc.addStyle(null, null);
        StyleConstants.setForeground(s, color);
        StyleConstants.setBackground(s, bgColor);

        try
        {
            pos = content.indexOf(text);
            while (-1 != pos)
            {
                doc.remove(pos, text.length());
                doc.insertString(pos, text, s);

                pos = content.indexOf(text, pos + 1);
            }
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    //��ע��order��������text order��1��ʼ��newText�������滻���ı�
    public void setTextColor(String text, String newText, int order, Color color, Color bgColor)
    {
        String content = null;
        try
        {
            content = getText();
        } catch(Exception e)
        {
            return;
        }

        int pos = -1;

        Style s = null;

        try
        {
            pos = content.indexOf(text);
            while (-1 != pos)
            {
                order --;
                if (0 == order)
                {
                    s = sc.addStyle(null, null);
                    StyleConstants.setForeground(s, color);
                    StyleConstants.setBackground(s, bgColor);
                    doc.remove(pos, text.length());
                    doc.insertString(pos, newText, s);
                    break;
                }

                pos = content.indexOf(text, pos + 1);
            }
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    public void removeColor()
    {
        try
        {
            String content = getText();
            doc.remove(0, doc.getLength());
            doc.insertString(0, content, null);
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    public void removeText()
    {
        try
        {
            doc.remove(0, doc.getLength());
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }
    }

    ///////////////////////////////////////////////////////
    public String getText()
    {
        try
        {
            return doc.getText(0, doc.getLength());
        } catch(Exception e)
        {
            e.printStackTrace(System.err);
        }

        return null;
    }

	//�����Ƿ���Ա༭
	public void setEditable(boolean flag)
	{
		editor.setEditable(flag);
	}
}
