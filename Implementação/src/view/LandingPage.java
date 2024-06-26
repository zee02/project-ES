package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class LandingPage extends JFrame {
    private JPanel mainPanel;
    private JTextField nomeTextField;
    private JButton entrarButton;

    // Lista de nomes autorizados
    private List<String> nomesAutorizados;

    // Listener para validar o nome
    private NomeValidadoListener nomeValidadoListener;

    public LandingPage() {
        // Inicialização da lista de nomes autorizados
        nomesAutorizados = new ArrayList<>();
        nomesAutorizados.add("Joao");
        nomesAutorizados.add("Juze");
        nomesAutorizados.add("Teixeira");

        // Configurações do JFrame
        setTitle("Landing Page - Nome");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os componentes da interface
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        nomeTextField = new JTextField(15);
        entrarButton = new JButton("Entrar");

        JPanel panelCenter = new JPanel();
        panelCenter.add(new JLabel("Digite seu nome:"));
        panelCenter.add(nomeTextField);

        mainPanel.add(panelCenter, BorderLayout.CENTER);
        mainPanel.add(entrarButton, BorderLayout.SOUTH);

        // Adiciona a ação ao botão "Entrar"
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeDigitado = nomeTextField.getText().trim();
                if (nomesAutorizados.contains(nomeDigitado)) {
                    if (nomeValidadoListener != null) {
                        nomeValidadoListener.nomeValidado(nomeDigitado);
                    }
                } else {
                    if (nomeValidadoListener != null) {
                        nomeValidadoListener.nomeInvalido();
                    }
                }
            }
        });

        // Define o painel principal do JFrame
        setContentPane(mainPanel);
    }

    // Método para adicionar um ouvinte de validação de nome
    public void addNomeValidadoListener(NomeValidadoListener listener) {
        this.nomeValidadoListener = listener;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LandingPage().setVisible(true);
            }
        });
    }
}
