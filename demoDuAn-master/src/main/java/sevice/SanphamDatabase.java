package sevice;

import model.Giohang;
import model.Sanpham;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SanphamDatabase {
    Config config = new Config();
    private final String LAY_SAN_PHAM = "select * from sanpham;";
    private final String TAO_SAN_PHAM = "insert into sanpham(tensanpham,dongia,soluong) value (?,?,?);";
    private final String THEM_GIO_HANG = "insert into giohang(idkh,idsp,soluongmua) value (?,?,?);";
    private final String TRU_SO_LUONG = "update sanpham set soluong = soluong - ? where id = ?;";
    private final String LAY_GIO_HANG = "select sanpham.id, sanpham.tensanpham, sanpham.dongia, sanpham.soluong, giohang.soluongmua from giohang join sanpham on sanpham.id = giohang.idsp where idkh = ?;";

    public List<Sanpham> getListSanpham() {
        List<Sanpham> sanphamList = new ArrayList<>();
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(LAY_SAN_PHAM);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String tensanpham = resultSet.getString(("tensanpham"));
                int dongia = resultSet.getInt("dongia");
                int soluong = resultSet.getInt("soluong");
                sanphamList.add(new Sanpham(id, tensanpham, soluong, dongia));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanphamList;
    }

    public void createSP(String ten, int dongia, int soluong) {
        try (Connection connection = config.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(TAO_SAN_PHAM);) {
            preparedStatement.setString(1, ten);
            preparedStatement.setInt(2, dongia);
            preparedStatement.setInt(3, soluong);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void oderSP(int idkh, int idsp, int soluongmua) {
        try (Connection connection = config.getConnection();
             PreparedStatement addOder = connection.prepareStatement(THEM_GIO_HANG);
             PreparedStatement truSL = connection.prepareStatement(TRU_SO_LUONG)
        ) {
            connection.setAutoCommit(false);
            addOder.setInt(1, idkh);
            addOder.setInt(2, idsp);
            addOder.setInt(3, soluongmua);
            addOder.executeUpdate();
            truSL.setInt(1, soluongmua);
            truSL.setInt(2, idsp);
            truSL.executeUpdate();
            connection.commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Giohang> getListGioHang(int idKH) {
        List<Giohang> list = new ArrayList<>();
        try (Connection connection = config.getConnection();
             PreparedStatement statement = connection.prepareStatement(LAY_GIO_HANG)
        ) {
            statement.setInt(1, idKH);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idsp = resultSet.getInt("id");
                String tensanpham = resultSet.getString("tensanpham");
                int dongia = resultSet.getInt("dongia");
                int soluong = resultSet.getInt("soluong");
                int soluongmua = resultSet.getInt("soluongmua");
                Sanpham sanpham = new Sanpham(idsp, tensanpham, soluong, dongia);
                Giohang giohang = new Giohang(sanpham, soluongmua);
                list.add(giohang);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
